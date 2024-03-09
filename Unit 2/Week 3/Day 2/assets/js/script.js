const nome = document.getElementById("nome"); 
const salva = document.getElementById("salva");
const reset = document.getElementById("reset");
const nomeSalvato = document.getElementById("nomeSalvato");

salva.addEventListener("click", function(e) {
    e.preventDefault();

    if (nome.value.trim() == "") {
        return;
    }
    localStorage.setItem("nome", nome.value);
    nomeSalvato.innerText=(`Il nome salvato è ${nome.value}`);
    nome.value=("");
})


reset.addEventListener("click", function(e) {
    e.preventDefault();

    localStorage.removeItem("nome");
    nomeSalvato.innerText=("");
})

const init = () => {
    let tempo = sessionStorage.getItem('tempo') || 0;
    const p = document.getElementById('tempo');
    p.innerText = `Sei nella sessione da ${tempo} secondi`;
    setInterval(() => {
        p.innerText = `Sei nella sessione da ${tempo} secondi`;
        tempo++;
        sessionStorage.setItem('tempo', tempo);
    }, 1000);
};

window.addEventListener('load', init);
