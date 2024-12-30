const apiUrl = "http://localhost:8080/tasks"; 

// Fetch tasks and display them
function fetchTasks() {
    fetch(apiUrl)
        .then((response) => response.json())
        .then((tasks) => displayTasks(tasks))
        .catch((error) => console.error("Error fetching tasks:", error));
}

// Display tasks in the UI
function displayTasks(tasks) {
    const taskList = document.getElementById("task-list");
    taskList.innerHTML = "";

    tasks.forEach((task) => {
        const li = document.createElement("li");
        li.className = `task-item ${task.completed ? "completed" : ""}`;
        li.innerHTML = `
            <div class="task-content">
                <span class="task-name">${task.name}</span>
                <span class="task-description">${task.description}</span>
            </div>
            <div class="task-actions">
                <button class="complete-btn" onclick="toggleTaskStatus(${task.id}, ${task.completed})">
                    ${task.completed ? "Completed" : "Complete"}
                </button>
                <button class="delete-btn" onclick="deleteTask(${task.id})">✖</button>
            </div>
        `;
        taskList.appendChild(li);
    });
}

// Add a new task
document.getElementById("task-form").addEventListener("submit", function (e) {
    e.preventDefault();
    const name = document.getElementById("taskName").value.trim();
    const description = document.getElementById("taskDescription").value.trim();

    if (name && description) {
        fetch(apiUrl, {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({ name, description, completed: false }),
        })
            .then(() => {
                fetchTasks();
                document.getElementById("taskName").value = "";
                document.getElementById("taskDescription").value = "";
            })
            .catch((error) => console.error("Error adding task:", error));
    }
});

// Toggle task completion status
function toggleTaskStatus(taskId, currentStatus) {
    fetch(`${apiUrl}/${taskId}`)
        .then((response) => response.json())
        .then((task) => {
            // Toggle the completed status
            const updatedTask = { ...task, completed: !currentStatus };

            fetch(`${apiUrl}/${taskId}`, {
                method: "PUT",
                headers: {
                    "Content-Type": "application/json",
                },
                body: JSON.stringify(updatedTask),
            })
                .then(() => fetchTasks())
                .catch((error) => console.error("Error toggling task status:", error));
        })
        .catch((error) => console.error("Error fetching task:", error));
}

// Delete a task
function deleteTask(taskId) {
    console.log(`Deleting task with ID: ${taskId}`);
    fetch(`${apiUrl}/${taskId}`, {
        method: "DELETE",
    })
        .then((response) => {
            if (!response.ok) {
                throw new Error("Failed to delete task");
            }
            fetchTasks(); // Refresh task list
        })
        .catch((error) => {
            console.error("Error deleting task:", error);
        });
}


// Initial load
fetchTasks();
