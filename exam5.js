function rotate(a) {
    if (a.length <= 1) {
        // 배열의 길이가 1 이하면 회전할 필요가 없습니다.
        return;
    }
    
    const lastValue = a.pop(); // 배열의 마지막 요소를 제거하고 저장
    a.unshift(lastValue); // 제거한 요소를 배열의 맨 앞에 추가
     } 
let a = [1, 2, 3, 4];
rotate(a); 
console.log(a);
      
rotate(a); 
console.log(a);