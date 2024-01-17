console.log("comment js in");
console.log(bnoVal);

document.getElementById('cmtPostBtn').addEventListener('click',()=>{
const cmtText = document.getElementById('cmtText');
if(cmtText.value == null || cmtText.value ==''){
   alert('댓글을 입력해주세용');
   cmtText.focus();
   return false;
}else{
   let cmtData = {
       bno: bnoVal,
       writer: document.getElementById('cmtWriter').innerText,
       content: cmtText.value
};
console.log(cmtData);
postCommentToServer(cmtData).then(result=>{
     if(result ==='1'){
        alert("댓글 등록 성공");
        cmtText.value="";
     }
     
     spreadCommentList(cmtData.bno);
})

}
});

async function postCommentToServer(cmtData){
    try {
       const url="/comment/post";
       const config={
         method: "post",
         headers: {
              'content-type': 'application/json; charset=utf-8'
         },
         body: JSON.stringify(cmtData)
       };
       const resp = await fetch(url, config);
       const result = await resp.text();
       return result;
    } catch(error) {
       console.log(error);
    }
};

function spreadCommentList(bno,page =1){
    getCommentListFromServer(bno, page).then(result =>{
    console.log(result);
    
    if(result.cmtList.length > 0){
       const ul = document.getElementById('cmtListArea');
       
       if(page ==1){
          ul.innerHTML='';
       }
       for(let cvo of result.cmtList){
          let li = `<li class="list-group-item" data-cno="${cvo.cno}" data-writer="${cvo.writer}">`;
                li += `<div class="mb-3">`;
                li += `<div class="fw-bold">${cvo.writer}</div>`;
                li += `${cvo.content}`;
                li += `</div>`;
                li += `<span class="badge rounded-pill text-bg-warning">${cvo.moddate}</span>`;
                li += `<button type="button" class="btn btn-outline-warning mod" data-bs-toggle="modal" data-bs-target="#myModal">e</button>`;
                li += `<button type="button" class="btn btn-outline-danger del">x</button>`;
                li += `</li>`;
                ul.innerHTML += li;
       }
       
       let moreBtn = document.getElementById('moreBtn');
       console.log(moreBtn);
       
       if(result.pgvo.pageNo < result.endPage){
          moreBtn.style.visibility = "visible";
          moreBtn.dataset.page = page +1;
       }else{
           moreBtn.style.visibility = "hidden";
       }
    }else{
       let li = `<li class="list-group-item">Comment List Empty</li>`;
       ul.innerHTML = li;
    }    
  })
};















