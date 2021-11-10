$(function (){
    $("nav li").on("click", function (){
        const className = $(this).className
        alert(className)
    })
})