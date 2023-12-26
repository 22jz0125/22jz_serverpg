(function(){
  'use strict'

  const btnGet = document.querySelector('.get');

  btnGet.addEventListener('click', () => {
    // APIを実行
    fetch('/ex0602/ItemServlet')
    .then(res => res.json())
    .then(data => {
      // console.log(data);
      if (data.name) {
        // レスポンスに名前が入ってれば成功とみなす
        const elName = document.querySelector('.name');
        const elPrice = document.querySelector('.price');
        const elDesc = document.querySelector('.description');
        elName.innerHTML = data.name;
        elPrice.innerHTML = data.price;
        elDesc.innerHTML = data.description;
      }
    });
  });
})();