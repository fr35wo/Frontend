function insertZero(a, index) {
    if (index < 0 || index > a.length) {
        console.error("유효한 인덱스 범위를 벗어났습니다.");
        return;
    }
    
    a.splice(index, 0, 0); 
    } 
let a = [1, 2, 3]; 
insertZero(a, 2); 
console.log(a);
insertZero(a, 1); 
console.log(a);