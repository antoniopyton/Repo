let articoli = []
const nome = document.getElementById("nomeInput")
const brand = document.getElementById("brandInput")
const prezzo = document.getElementById("prezzoInput")
const url = document.getElementById("urlInput")
const descrizione = document.getElementById("descrizioneInput")
const elimina = document.getElementById("delete")
const salva = document.getElementById("salva")
let id;

window.addEventListener('load', init)


const cercaFetch = async () => {
    try {
        const caricamento = await fetch("https://striveschool-api.herokuapp.com/api/product/", {
            headers: {
                "Authorization": "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NWVhZWFiMDJkN2IxMTAwMTkwZTZmZmEiLCJpYXQiOjE3MDk4OTQzMjAsImV4cCI6MTcxMTEwMzkyMH0.8cDM_DIErBsEv4hihTMhxnq8Y0vaSGR-reBH-SOlPEc"
            }
        })
        const response = await caricamento.json();
        articoli = response;
        console.log("Articoli recuperati", articoli)
    }

    catch (error) {
        console.log(error);
    }
}

function recuperoDati(dataString) {
    articoli.forEach((element) => {
        if (element._id == dataString) {
            nome.value = element.name
            brand.value = element.brand
            prezzo.value = element.price
            descrizione.value = element.description
            url.value = element.imageUrl
        }
    })
}

const cancellaArticolo = async function (id) {
    try {
        let risposta = await fetch("https://striveschool-api.herokuapp.com/api/product/" + id, {
            method: "DELETE",
            headers: {
                "Authorization": "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NWVhZWFiMDJkN2IxMTAwMTkwZTZmZmEiLCJpYXQiOjE3MDk4OTQzMjAsImV4cCI6MTcxMTEwMzkyMH0.8cDM_DIErBsEv4hihTMhxnq8Y0vaSGR-reBH-SOlPEc",
                "Content-Type": "application/json"

            }
        });
        if (risposta.ok) {
            console.log(`Articolo con ID ${id} eliminato con Successo`);
            window.location.href = "index.html"
        } else {
            console.log(`C'è stato un errore con l'eliminazione dell'articolo con ID ${id}`)
        }

    } catch (error) {
        console.log(error)
    }


}

elimina.addEventListener('click', (e) => {
    e.preventDefault()
    let conferma = confirm("Sei sicuro di voler eliminare l'articolo?")
    const urlParams = new URLSearchParams(window.location.search);
    const dataString = urlParams.get('id');
    if (dataString) {
        (confirm("Non potrai più tornare indietro"))
        if (conferma) {
            cancellaArticolo(dataString);
        }
    } else {
        console.error("ID dell'articolo non valido o mancante");
    }
    if (conferma) {
        cancellaArticolo()
    };



})

async function init() {
    await cercaFetch()
    const urlParams = new URLSearchParams(window.location.search);
    id = urlParams.get('id');
    if (id) {
        recuperoDati(id)
    }
}

const modificaProdotto = async (prodottoModificato) => {
    try {
        const caricamento = await fetch("https://striveschool-api.herokuapp.com/api/product/" + id, {
            method: "PUT",
            headers: {
                "Authorization": "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NWVhZWFiMDJkN2IxMTAwMTkwZTZmZmEiLCJpYXQiOjE3MDk4OTQzMjAsImV4cCI6MTcxMTEwMzkyMH0.8cDM_DIErBsEv4hihTMhxnq8Y0vaSGR-reBH-SOlPEc",
                "Content-Type": "application/json"
            },
             body: JSON.stringify(prodottoModificato)
        });
        if (caricamento.ok) {
            console.log("Prodotto modificato con successo")

            window.location.href = "index.html"
        } else {
            console.log("Errore durante la modifica del prodotto", caricamento.status)
        }
    } catch (error) {
        console.error("Errore generico durante l'aggiunta del prodotto", caricamento.status)
    }
}

salva.addEventListener("click", async (e) => {
    e.preventDefault();

    const nomeArt = nome.value
    const brandArt = brand.value
    const prezzoArt = prezzo.value
    const imageUrl = url.value
    const descrizioneArt = descrizione.value

    const prodottoModificato = { name: nomeArt, brand: brandArt, price: prezzoArt, imageUrl: imageUrl, description: descrizioneArt };

    await modificaProdotto(prodottoModificato);
})
