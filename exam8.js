function countSpace(s) { 
    let spaceCount = 0;
    
    for (let i = 0; i < s.length; i++) {
        if (s[i] === ' ') {
            spaceCount++;
        }
    }
    
    return spaceCount;
} 
console.log(countSpace("aa bb ccc")); 
console.log(countSpace("a b cc ddd  e"));