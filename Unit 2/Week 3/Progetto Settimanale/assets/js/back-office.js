let articoli = []
const nome = document.getElementById("nomeInput")
const brand = document.getElementById("brandInput")
const prezzo = document.getElementById("prezzoInput")
const imageUrl = document.getElementById("imageUrl")
const descrizione = document.getElementById("descrizioneInput")
const salva = document.getElementById("salva")

const aggiungiArticolo = async (nuovoArticolo) => {
    try {
        const carica = await fetch("https://striveschool-api.herokuapp.com/api/product", {
            method: "POST",
            headers: {
                "Authorization": "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NWVhZWFiMDJkN2IxMTAwMTkwZTZmZmEiLCJpYXQiOjE3MDk4OTQzMjAsImV4cCI6MTcxMTEwMzkyMH0.8cDM_DIErBsEv4hihTMhxnq8Y0vaSGR-reBH-SOlPEc",
                "Content-Type": "application/json"
            },
             body: JSON.stringify(nuovoArticolo)
        });
        if (carica.ok) {
            console.log("Prodotto inserito con successo")

            window.location.href = "index.html"
        } else {
            console.log("Errore durante l'aggiunta del prodotto", carica.status)
        }
    } catch (error) {
        console.error("Errore generico durante l'aggiunta del prodotto", carica.status)
    }
    
    }

salva.addEventListener('click', async (e) => {
    e.preventDefault();

    const nomeArt = nome.value;
    const brandArt = brand.value;
    const prezzoArt = prezzo.value;
    const imageUrlArt = imageUrl.value;
    const descrizioneArt = descrizione.value;

    const nuovoArticolo = { name: nomeArt, brand: brandArt, price: prezzoArt, imageUrl: imageUrlArt, description: descrizioneArt };

    await aggiungiArticolo(nuovoArticolo);
});

