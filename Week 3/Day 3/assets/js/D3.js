const ul = document.getElementById('lista');
const form = document.getElementById('form');
const crea = document.getElementById('crea');
const task = document.getElementById('taskInput');
const bttn = document.getElementById('inserisci');
const errore = document.getElementById('errore');
let valid = false;


const array = [];

window.addEventListener('load', init());

function init() {
    if (!valid) {
        bttn.setAttribute('disabled', 'true');

    }
    
}
task.addEventListener('blur', function()  //blur serve a spostare l'attenzione altrove
 {
    if(task.value == '') {
        errore.innerText = 'Scrivi una task, o il tasto non si sblocca!!';
        bttn.setAttribute('disabled', 'true');
    } else {
        bttn.removeAttribute('disabled')
    }
})

function aggiungiTask() {
    if(task.value === '') return;
    const li = document.createElement('li');
    li.innerText = task.value;
    ul.appendChild(li);
}

const deleteButton = document.createElement