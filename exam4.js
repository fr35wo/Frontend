function createArray(count) { 
    if (count < 1) {
        console.error("count는 1 이상");
        return [];
    }
    
    const result = [];
    for (let i = 0; i < count; i++) {
        const randomNumber = Math.random() * 5; // 0 이상 5 미만의 난수 생성
        result.push(randomNumber);
    }
    
    return result;
}

console.log(createArray(2)); 
console.log(createArray(3)); 
console.log(createArray(4)); 
console.log(createArray(5));