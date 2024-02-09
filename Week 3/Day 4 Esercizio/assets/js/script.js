const tabellone = document.getElementById('tabellone');
const bottone = document.getElementById('button');
const tombolaArray = [];
const tombolaUsciti = [];

const creaTabellone = () => {

    for (let i = 0; i < 90; i++) {
        const div = document.createElement('div');
        const span = document.createElement('span');
        span.innerText = i + 1;
        div.setAttribute("id", `numero-${i}`);
        div.classList.add("cella");
        div.appendChild(span);
        tabellone.appendChild(div);
        tombolaArray.push(i);

    }


}
const generaNumero = () => {
    let numero = Math.floor(Math.random() * tombolaArray.length) + 1;
    let find = tombolaUsciti.indexOf(numero);
    if (find === -1) {
        tombolaUsciti.push(numero)
        const cella = document.getElementById(`numero-${(numero-1)}`)
        cella.classList.add('numero-uscito');
    } else {
        generaNumero();
    }

}

bottone.addEventListener('click', function(e){
    e.preventDefault();
    generaNumero();
})


window.addEventListener("load", function () {
    creaTabellone();

});



