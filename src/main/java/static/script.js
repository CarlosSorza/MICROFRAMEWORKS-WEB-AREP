// Selección de elementos del DOM
const taskInput = document.getElementById('taskInput');
const addTaskButton = document.getElementById('addTaskButton');
const taskList = document.getElementById('taskList');

// Función para agregar una nueva tarea
function addTask() {
    const taskText = taskInput.value.trim();
    if (taskText !== '') {
        const listItem = document.createElement('li');
        listItem.className = 'task-item';

        const taskSpan = document.createElement('span');
        taskSpan.textContent = taskText;
        taskSpan.className = 'task-text';
        listItem.appendChild(taskSpan);

        const completeButton = document.createElement('button');
        completeButton.textContent = 'Completar';
        completeButton.className = 'complete-button';
        completeButton.onclick = () => completeTask(listItem);
        listItem.appendChild(completeButton);

        const deleteButton = document.createElement('button');
        deleteButton.textContent = 'Eliminar';
        deleteButton.className = 'delete-button';
        deleteButton.onclick = () => deleteTask(listItem);
        listItem.appendChild(deleteButton);

        taskList.appendChild(listItem);
        taskInput.value = '';
    }
}

// Función para marcar una tarea como completada
function completeTask(listItem) {
    const taskText = listItem.querySelector('.task-text');
    taskText.classList.toggle('completed');
}

// Función para eliminar una tarea
function deleteTask(listItem) {
    taskList.removeChild(listItem);
}

// Evento para agregar tarea al hacer clic en el botón
addTaskButton.addEventListener('click', addTask);

// Evento para agregar tarea al presionar Enter
taskInput.addEventListener('keypress', (event) => {
    if (event.key === 'Enter') {
        addTask();
    }
});
