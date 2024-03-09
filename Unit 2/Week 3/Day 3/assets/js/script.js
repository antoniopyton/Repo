let libreria = []
let shop = []

creaCard = (libro, colonna) => {
    const card = document.createElement('div')
    card.classList.add('card')
    card.classList.add('h-100')

    const img = document.createElement('img')
    img.src = libro.img;
    img.height = "400"
    img.classList.add('card-img-top');
    img.setAttribute('alt', libro.title)

    const body = document.createElement('div')
    body.classList.add('card-body')

    const titolo = document.createElement('h5')
    titolo.classList.add('card-title')
    titolo.innerText = libro.title

    const prezzo = document.createElement('p')
    prezzo.classList.add('card-text', 'fw-bold')
    prezzo.innerText = `$${libro.price}`

    const Scarta = document.createElement('a')
    Scarta.setAttribute('href', 'javascripting:void(0)')
    Scarta.classList.add('btn', 'btn-danger')
    Scarta.innerText = 'Scarta'
    Scarta.addEventListener('click', (e) => {
        e.preventDefault();
        colonna.style.display = "none";
    })

    const aggiungi = document.createElement('a')
    aggiungi.setAttribute('href', 'javascripting:void(0)')
    aggiungi.classList.add('btn', 'btn-success')
    aggiungi.innerText = 'Aggiungi'
    aggiungi.addEventListener('click', (e) => {
        e.preventDefault();

        shop.push(libro)
        localStorage.setItem('shop', JSON.stringify(shop))
    })

    body.append(titolo, prezzo, aggiungi, Scarta)
    card.append(img, body)
    return card

}



const generaLibreria = () => {
    const libri = document.getElementById('libri')
    libreria.forEach((element) => {
        const col = document.createElement('div')
        col.classList.add('col-3', 'my-2')
        const card = creaCard(element, col)
        col.appendChild(card)
        libri.appendChild(col)
    })
}


const ricercaApi = () => {
    let response = fetch('https://striveschool-api.herokuapp.com/books')
        .then((risposta) => {
            return risposta.json();
        })
        .then((data) => {
            libreria = data;
            generaLibreria();
        })

}


const init = () => {
    ricercaApi()
}


window.addEventListener('load', init)