function createArray() { 
   let a = [[1,2],[3,4,5],[]];
   a[2] = a[1];
   return a;
} 
console.log(createArray());