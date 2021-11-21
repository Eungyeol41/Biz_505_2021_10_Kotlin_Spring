$(function (){
    $("nav li").on("click", function (){
        const className = $(this).attr("class")

        if(className === "home") {
            location.href = `${rootPath}`
        } else if(className === "list") {
            location.href = `${rootPath}list`
        } else if(className === "insert") {
            location.href = `${rootPath}insert`
        } else if(className === "login") {
            location.href = `${rootPath}member/login`
        } else if(className === "join") {
            location.href = `${rootPath}member/join`
        } else if(className === "mypage") {
            location.href = `${rootPath}member/mypage`
        }
    })
})
