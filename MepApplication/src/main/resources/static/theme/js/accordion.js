$(function() {
	var thisChild2 = "";
	$(".accordion .name").click(
			function() {
				$(".accordion").children(".discription").slideUp();
				var thisChild = $(this).parents(".accordion").children(
						".discription").html();
				if (thisChild != thisChild2) {
					$(this).parents(".accordion").children(".discription")
							.slideDown();
					thisChild2 = thisChild;
				}

				else {
					thisChild2 = "";
				}
				return false;
			});
	$(".accordion .discription").hide();
});