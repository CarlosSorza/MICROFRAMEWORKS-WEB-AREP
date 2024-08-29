// Crear una lista vacía de tareas
let tareas = [];

// Función para agregar una tarea
function agregarTarea(tarea) {
    tareas.push(tarea);
    mostrarTareas();
}

// Función para eliminar una tarea por su índice
function eliminarTarea(indice) {
    tareas.splice(indice, 1);
    mostrarTareas();
}

// Función para mostrar las tareas en la consola
function mostrarTareas() {
    console.clear();
    tareas.forEach((tarea, indice) => {
        console.log(`${indice + 1}. ${tarea}`);
    });
}

// Ejemplo de uso
agregarTarea('Aprender JavaScript');
agregarTarea('Leer un libro');
eliminarTarea(0);
