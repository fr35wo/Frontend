function removeSpace(s) { 
    let result = "";

    for (let i = 0; i < s.length; i++) {
        if (s[i] !== ' ') {
            result += s[i];
        }
    }

    return result;
} 
console.log(removeSpace("aa bb ccc")); 
console.log(removeSpace("a b cc ddd e"));