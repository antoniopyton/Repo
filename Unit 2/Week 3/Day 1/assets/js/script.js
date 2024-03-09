class User {
    constructor(firstName, lastName, age, location) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.location = location;
    }
    confronto = function (utenteDue) {
        if(this.age > utenteDue.age){
            console.log(`${this.firstName} è più grande di ${utenteDue.firstName}`)
        } else if 
            (this.age < utenteDue.age) {
                console.log(`${this.firstName} è più piccolo di ${utenteDue.firstName}`)
        } else {
        (this.age == utenteDue.age) 
            console.log(`${this.firstName} ha la stessa età di ${utenteDue.firstName}`)
    }
}
}

const userUno = new User ("Antonio", "Copetti", 25, "Napoli");
const userDue = new User ("Luigi", "Copetti", 27, "Napoli");
const userTre = new User ("Giulio", "Bianchi", 32, "Salerno");

userDue.confronto(userUno);