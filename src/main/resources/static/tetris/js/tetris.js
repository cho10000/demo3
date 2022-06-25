// export default BLOCKS;
import BLOCKS from "./blocks.js"
//dom
const playground = document.querySelector(".playground > ul");
const gameText =  document.querySelector(".game-text");
const scoreDisplay =  document.querySelector(".score");
const restartButton =  document.querySelector(".game-text > button");

// console.log(playground)

//setting
const GAME_ROWS = 20;
const GAME_COLS = 10;

//vairables
let score = 0;
let duration = 500;
let downInterval ;
let tempMovingItem;


const movingItem = {
    type : "",
    direction : 0,
    top : 0,
    left : 3,
};

init()         

//function
function init() {
//    console.log(BLOCKS);
    //const randomIndex = Math.floor(Math.random() * 6)
    
    tempMovingItem = { ...movingItem };    

    for ( let i=0; i < GAME_ROWS; i++) {
        prepndNewline()
    }
    // renderBlocks();
    generateNewBlock();

}

function prepndNewline() {
    const li = document.createElement("li")
    const ul  = document.createElement("ul")
    for (let j=0; j <GAME_COLS; j++) {
        const matrix = document.createElement("li")
        ul.prepend(matrix);

    }
    li.prepend(ul)
    playground.prepend(li)

}


function renderBlocks(moveType = "") {
    const { type, direction, top, left } = tempMovingItem;
    const movingBlocks = document.querySelectorAll(".moving");
    movingBlocks.forEach(moving => {
        moving.classList.remove(type, "moving");
        // console.log(moving)    
    })
    

    BLOCKS[type][direction].some(block => {
        const x = block[0] + left;
        const y = block[1] + top;
        // 삼항 연산자 : ==>  조건? 참 : 거짓"
        const target = playground.childNodes[y] ?  playground.childNodes[ y].childNodes[0].childNodes[x] : null;
        const isAvailable = checkEmpty(target);
        if (isAvailable) {
            target.classList.add(type, "moving");            
        } else {
                tempMovingItem = { ...movingItem}
                if (moveType === "retry") {
                    clearInterval(downInterval);
                    showGameoverText()
                }
            
                setTimeout(() => {
                    renderBlocks("retry");                
                    if (moveType === "top") {
                    // renderBlocks();
                        seizeBlock();                    
                    }            
                }, 0)
                
            return true;
        }
        
      //console.log(target.classList);
        target.classList.add(type, "moving")
        })
    // console.log(BLOCKS[type][direction])
    movingItem.left = left;
    movingItem.top = top;
    movingItem.direction = direction;
    
}

function showGameoverText() {
    gameText.style.display = "flex";

}    
function seizeBlock() {
    const movingBlocks = document.querySelectorAll(".moving");
    movingBlocks.forEach(moving => {
        moving.classList.remove("moving");
        moving.classList.add("seized");
    })    
    checkMatch();
    // generateNewBlock() ;
}
function checkMatch() {
    const childNodes = playground.childNodes;
    childNodes.forEach(child => {
        let matched = true;
        child.children[0].childNodes.forEach(li => {
            if (!li.classList.contains("seized")) {          
                matched = false;                
            }
        })
        
        if (matched) {
            child.remove();         
            prepndNewline();
            score++;
            scoreDisplay.innerHTML = score; 
        }
    })
    generateNewBlock();
}
function generateNewBlock() {

    clearInterval(downInterval);
    downInterval = setInterval(() => {
        moveBlock("top",1)
     }, duration);
    const blockArray = Object.entries(BLOCKS);
    const randomIndex = Math.floor(Math.random() * blockArray.length)
    // console.log(blockArray);
    

    movingItem.type = blockArray[randomIndex][0];
    //movingItem.type = "zee2";
    movingItem.top =0;
    movingItem.left = 3;
    movingItem.direction =0;
    tempMovingItem = {...movingItem};
    renderBlocks();
    

}
function checkEmpty(target) {    
    if (!target || target.classList.contains("seized")) {
        return false;
    }
    return true;
}

function dropBlock() {
     clearInterval(downInterval);
     downInterval = setInterval(() => {
         moveBlock("top",1)
     }, 10)
}

function moveBlock(moveType, amount) {
    tempMovingItem[moveType] += amount;
    renderBlocks(moveType)
}

function changeDirection() {
    const direction = tempMovingItem.direction;
    direction === 3 ? tempMovingItem.direction = 0: tempMovingItem.direction +=1; 
    renderBlocks();
}

//event handling

document.addEventListener("keydown", e=> {
    switch(e.key) {
        case "ArrowRight"  :
        case "Right":    
            moveBlock("left",1);
           // console.log("right");
            break;
        case "ArrowLeft"  :
        case "Left":    
          //  console.log("left");
            moveBlock("left",-1);
            break;
        case "Up": // IE/Edge specific value
        case "ArrowUp":
          //  console.log("ArrowUp");
            changeDirection();
            break;            
        case "Down": // IE/Edge specific value
        case "ArrowDown":
          //  console.log("ArrowDown");
            moveBlock("top",1);
            break;
        case " ":
              console.log("Space");
                dropBlock();
                break;              
        default:
            break;
    }   
 // console.log(e)
})

restartButton.addEventListener("click",() => {
    playground.innerHTML = "";
    gameText.style.display = "none";
    init();
})