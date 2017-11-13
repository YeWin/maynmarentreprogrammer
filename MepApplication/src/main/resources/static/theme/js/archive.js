$(document).ready(function(){
    $("#accordion h3").click(function(){
        $(this).next().slideToggle();
    })
    $("#accordion h4").click(function(){
        $(this).next().slideToggle();
    })
     $("#accordion ul ul li a").click(function(){
        $(this).next().slideToggle();
    })
})