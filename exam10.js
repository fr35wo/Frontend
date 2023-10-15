function testCallback(f, a, b) { 
    const result = f(a, b);
    console.log(result);
} 
testCallback((a, b) => a + b, 3, 4); 
testCallback((a, b) => a * b, 3, 4);