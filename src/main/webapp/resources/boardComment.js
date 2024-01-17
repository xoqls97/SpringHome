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



