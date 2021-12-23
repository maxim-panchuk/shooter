//localStorage.setItem("dots", JSON.stringify([]))
//localStorage.setItem("lastname", "-1")
let radius = null

const GRAPH = document.getElementById("area-graph")
const RECT = GRAPH.getBoundingClientRect()
const RESET = document.forms[0][9]
const SEND = document.forms[0][8]

window.addEventListener("load", ()=>{
    radius = localStorage.getItem("radius")
    if (radius != null) {
        let neg = document.querySelectorAll(".negative-coords")
        let pos = document.querySelectorAll(".positive-coords")
        pos.forEach(element => {
            element.innerHTML = `${radius}`
        })
        neg.forEach(element => {
            element.innerHTML = `-${radius}`
        })
        updDots(GRAPH, radius)
    }
})

RESET.addEventListener("click", () => {
    localStorage.setItem("dots", JSON.stringify([]))
    localStorage.setItem("lastname", "-1")
})

SEND.addEventListener("click", () => {

    // Еще добавить валижацию JS перед тем как идти дальше

    let currentX = document.forms[0][1].value
    let currentY = document.forms[0][2].value
    let xVal = currentX * (140 / radius) + 175
    let yVal = -(currentY * 140 / radius) + 175

    let storedDots = JSON.parse(localStorage.getItem("dots"))
    let lastName = parseInt(localStorage.getItem("lastname"))
    localStorage.setItem("lastname", lastName + 1)
    let newDot = new Dot({
        name: lastName + 1,
        x: currentX,
        y: currentY
    })
    storedDots.push(newDot)
    localStorage.setItem("dots", JSON.stringify(storedDots))
    updSVG(GRAPH, parseFloat(currentX), parseFloat(currentY))
})

function drawDot(radius, GRAPH, RECT, event) {
    let storedDots = JSON.parse(localStorage.getItem("dots"))
    let xCor = (event.clientX - RECT.left)
    let yCor = (event.clientY - RECT.top)
    let currentX = (xCor - 175) / (140 / radius)
    let currentY = -(yCor - 175) / (140 / radius)
    let lastName = parseInt(localStorage.getItem("lastname"))
    localStorage.setItem("lastname", lastName + 1)
    let newDot = new Dot({
        name: lastName + 1,
        x: currentX.toFixed(3),
        y: currentY.toFixed(3)
    })
    storedDots.push(newDot)
    localStorage.setItem("dots", JSON.stringify(storedDots))
    updSVG(GRAPH, xCor, yCor)
}


GRAPH.addEventListener("click", (event) => {
    if (radius != null) {
        drawDot(radius, GRAPH, RECT, event)

        let xCor = (event.clientX - RECT.left)
        let yCor = (event.clientY - RECT.top)
        let currentX = (xCor - 175) / (140 / radius)
        let currentY = -(yCor - 175) / (140 / radius)

        document.forms[1][1].value = currentX.toFixed(3)
        document.forms[1][2].value = currentY.toFixed(3)
        document.forms[1][3].value = radius
        document.forms[1][4].click();
    }
})

document.forms[0].addEventListener("click", (event) => {
    if (event.target && event.target.matches("input[type='radio']")) {

        for (let i = 0; i < 5; i++) {
            if (document.forms[0][3 + i].checked === true) {
                radius = document.forms[0][3 + i].value
            }
        }
        localStorage.setItem("radius", radius);
        let neg = document.querySelectorAll(".negative-coords")
        let pos = document.querySelectorAll(".positive-coords")
        pos.forEach(element => {
            element.innerHTML = `${radius}`
        })
        neg.forEach(element => {
            element.innerHTML = `-${radius}`
        })
        updDots(GRAPH, radius)
    }
})

function updDots(GRAPH, radius) {
    let storedDots = JSON.parse(localStorage.getItem("dots"))
    document.querySelectorAll("circle").forEach(item => item.remove())
    for (let i = 0; i < storedDots.length; i++) {
        let x = parseFloat(storedDots[i]["x"])
        let y = parseFloat(storedDots[i]["y"])
        let xVal = x * (140 / radius) + 175
        let yVal = -(y * 140 / radius) + 175
        updSVG(GRAPH, xVal, yVal)
    }
}
function updSVG(GRAPH, x, y) {
    let dot = document.createElementNS("http://www.w3.org/2000/svg", "circle")
    dot.setAttribute("cx", x);
    dot.setAttribute("cy", y);
    dot.setAttribute("r", "3");
    let currentX = (x - 175) / (140 / radius)
    let currentY = -(y - 175) / (140 / radius)
    if (currentX <= 0 && currentY >= 0 && Math.sqrt(Math.pow(currentX, 2)
            + Math.pow(currentY, 2)) <= radius / 2 ||
        currentX <= 0 && currentY <= 0 && currentX >= -radius && currentY >= -radius ||
        currentX >= 0 && currentY <= 0 && currentY >= (currentX - radius)) {
        dot.setAttribute("stroke", "#00ff32");
        dot.setAttribute("fill", "#00ff32");
    }
    else {
        dot.setAttribute("stroke", "#AD2D2D");
        dot.setAttribute("fill", "#AD2D2D");
    }
    GRAPH.appendChild(dot)
}
class Dot {
    static type = "Dot"

    constructor (options) {
        this.name =     options.name
        this.x =        options.x
        this.y =        options.y
    }

    sout() {
        console.log("Name: " + this.name + " x: " + this.x + " y: " + this.y)
    }
}



