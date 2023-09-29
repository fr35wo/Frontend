function createArray(count) { 
    if (count < 1 || count > 5) {
        console.error("count는 1 이상 5 이하의 정수");
        return [];
    }
    
    const result = [];
    for (let i = 1; i <= count; i++) {
        result.push(i);
    }
    
    return result;
}

console.log(createArray(6));

console.log(createArray(2)); 
console.log(createArray(3)); 
console.log(createArray(4));
console.log(createArray(5));