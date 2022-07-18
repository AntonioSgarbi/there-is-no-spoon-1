/**
 * Don't let the machines win. You are humanity's last hope...
 **/

const width = parseInt(readline()); // the number of cells on the X axis
const height = parseInt(readline()); // the number of cells on the Y axis
let coordinates = [];

for (let i = 0; i < height; i++) {
    const line = readline(); // width characters, each either 0 or .
    for(let j = 0; j < width; j++) {
        if(line.charAt(j) == '0') {
            let coordinate = {x: j, y: i}
            coordinates.push(coordinate)
        }
    }
}

for(c of coordinates) {
    let indexRight = coordinates.findIndex((c2) => c2.y == c.y && c2.x > c.x)
    let indexBelow = coordinates.findIndex((c2) => c2.x == c.x && c2.y > c.y)
    
    let nodeRight = indexRight == -1 ? '-1 -1' : `${coordinates[indexRight].x} ${coordinates[indexRight].y}`
    let nodeBelow = indexBelow == -1 ? '-1 -1' : `${coordinates[indexBelow].x} ${coordinates[indexBelow].y}`

    console.log(`${c.x} ${c.y} ${nodeRight} ${nodeBelow}`)
}
