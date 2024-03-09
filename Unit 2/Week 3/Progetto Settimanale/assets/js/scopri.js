const nome = document.getElementById("nomeInput")
const brand = document.getElementById("brandInput")
const prezzo = document.getElementById("prezzoInput")
const imageUrl = document.getElementById("imageUrl")
const descrizione = document.getElementById("descrizioneInput")
const elimina = document.getElementById("delete")


window.addEventListener('load', init) 


const cercaFetch = async (id) => {
    try {
        const caricamento = await fetch("https://striveschool-api.herokuapp.com/api/product/" + id, {
            headers: {
                "Authorization": "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NWVhZWFiMDJkN2IxMTAwMTkwZTZmZmEiLCJpYXQiOjE3MDk4OTQzMjAsImV4cCI6MTcxMTEwMzkyMH0.8cDM_DIErBsEv4hihTMhxnq8Y0vaSGR-reBH-SOlPEc"
            }
        })
        const response = await caricamento.json();
        return response
    }

    catch (error) {
        console.log(error);
    }
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

async function recuperoDati(id) {
        const articolo = await cercaFetch(id)
        nome.innerText = articolo.name
        brand.innerText = articolo.brand
        prezzo.innerText = articolo.price
        descrizione.innerText = articolo.description
        imageUrl.src = articolo.imageUrl
        }

async function init() {
    const urlParamas = new URLSearchParams(window.location.search)
    const id = urlParamas.get('id')
    if (id) {
        recuperoDati(id)
    }
}

const aggiornaProdotto = async (nuovoProdotto) => {
    try {
        const caricamento = await fetch("https://striveschool-api.herokuapp.com/api/product/"+id, {
            method: "PUT",
            headers: {
                "Authorization": "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NWVhZWFiMDJkN2IxMTAwMTkwZTZmZmEiLCJpYXQiOjE3MDk4OTQzMjAsImV4cCI6MTcxMTEwMzkyMH0.8cDM_DIErBsEv4hihTMhxnq8Y0vaSGR-reBH-SOlPEc",
                "Content-Type": "application/json"
            },
            body: JSON.stringify(nuovoProdotto)
        });

        if (caricamento.ok) {
            console.log("Prodotto modificato con successo!");
            window.location.href = "index.html"
        } else {
            console.error("Errore durante la modifica del prodotto:", caricamento.status);
            const errorMessage = await caricamento.text();
            console.error("Messaggio di errore:", errorMessage);
        }

    } catch (error) {
        console.error("Errore generico durante la modifica del prodotto:", error);
    }
}







