const BoardList={
  props:{boardList:[], boardListTitle: String},  // : 뒤의 형으로 받겠다....
  template:`<div class="myBox">
    <h3>[자유 게시판]</h3>
    <div>{{boardListTitle}}</div>
    <table border="1">
      <tr><th>no</th><th>title</th><th>writer</th></tr>
      <tr v-for="item in boardList"><td>{{item.no}}</td><td>{{item.title}}</td><td>{{item.writer}}</td></tr>
    </table>
    <button @click="boardWriteForm()">글작성</button>
    </div>`,
    methods:{
      boardWriteForm(){
        this.$emit('board-write-form');  // 전달하는 역할
      },
    },
};

export default BoardList