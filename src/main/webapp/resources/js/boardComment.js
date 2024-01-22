console.log("comment js in");
console.log(bnoVal);

document.getElementById('cmtPostBtn').addEventListener('click', () => {
   const cmtText = document.getElementById('cmtText');
   if (cmtText.value == null || cmtText.value == '') {
      alert('댓글을 입력해주세용');
      cmtText.focus();
      return false;
   } else {
      let cmtData = {
         bno: bnoVal,
         writer: document.getElementById('cmtWriter').innerText,
         content: cmtText.value
      };
      console.log(cmtData);
      postCommentToServer(cmtData).then(result => {
         if (result === '1') {
            alert("댓글 등록 성공");
            cmtText.value = "";
         }

         spreadCommentList(cmtData.bno);
      })

   }
});

async function postCommentToServer(cmtData) {
   try {
      const url = "/comment/post";
      const config = {
         method: "post",
         headers: {
            'content-type': 'application/json; charset=utf-8'
         },
         body: JSON.stringify(cmtData)
      };
      const resp = await fetch(url, config);
      const result = await resp.text();
      return result;
   } catch (error) {
      console.log(error);
   }
};

function spreadCommentList(bno) {
   getCommentListFromServer(bno).then(result => {
      console.log(result);

      if (result.length > 0) {
         const ul = document.getElementById('cmtListArea');

         ul.innerHTML = '';

         for (let cvo of result) {
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


      } else {
         let li = `<li class="list-group-item">Comment List Empty</li>`;
         ul.innerHTML = li;
      }
   })
};

async function getCommentListFromServer(bno) {
   try {
      const resp = await fetch("/comment/list" + bno);
      const result = await resp.json();
      return result;
   } catch (error) {
      console.log(error);
   }
};

async function editCommentToServer(cmtDataMod) {
   try {
      const url = "/comment/edit";
      const config = {
         method: "put",
         headers: {
            'content-type': 'application/json; charset=utf-8'
         },
         body: JSON.stringify(cmtDataMod)

      };
      const resp = await fetch(url, config);
      const result = await resp.text();
      return result;
   } catch (error) {
      console.log(error);
   }

}

document.addEventListener('click', (e) => {
   console.log(e.target);
   if (e.target.classList.contains('mod')) {
      let li = e.target.closest('li');

      let cmtText = li.querySelector('.fw-bold').nextSibling;
      console.log(cmtText);

      document.getElementById('cmtTextMod').value = cmtText.nodeValue;
      document.getElementById('cmtModBtn').setAttribute("data-cno", li.dataset.cno);
      document.getElementById('cmtModBtn').setAttribute("data-writer", li.dataset.writer);
   } else if (e.target.id == 'cmtModBtn') {
      let cmtDataMod = {
         cno: e.target.dataset.cno,
         writer: e.target.dataset.writer,
         content: document.getElementById('cmtTextMod').value

      };
      console.log(cmtDataMod);
      editCommentToServer(cmtDataMod).then(result => {
         if (result == "1") {
            alert('댓글 수정 성공');
            document.querySelector('.btn-close').click();
         }
         spreadCommentList(bnoVal);
      })


   } else if (e.target.classList.contains('del')) {
      let li = e.target.closest('li');
      let cno = li.dataset.cno;
      deleteCommentToServer(cno).then(result => {
         if (result == "1") {
            alert('댓글 삭제 성공');
         }
         spreadCommentList(bnoVal);
      })

   }

})

async function deleteCommentToServer(cno) {
   try {
      const url = '/comment/delete';
      const config = {
         method: "delete",
         headers: {
            'content-type': 'application/json; charset=utf-8'
         },
         body: JSON.stringify(cno)
      };
      const resp = await fetch(url, config);
      const result = await resp.text();
      return result;

   } catch (error) {
      console.log(error);
   }

}

















