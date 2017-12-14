//menu desktop & mobile
(function()
		{
				(
						function(e, t)
						{"use strict";
								return e.fn.flexMenu = function(n)
								{return this.each
										(function()
												{var r, i, s, o, u, a, f, l, c, h, p, d, v; d = e.extend
														(
																{breakpoint: 975, responsivePattern: "toggle"}, n);
														u = e(this); o = u.find("li");
														f = e(t);
														v = void 0; r = e("body");

														u.addClass("flexmenu");
														i = e(".fm-button");
														l = function() {var t;
																u.find("li").each(function()
																		{var t;
																				t = e(this); if(t.has("ul").length)return t.addClass("with-ul").find("ul").hide()}
																);
																t = u.find(".with-ul");
																t.append('<span class="navicon"></span>');
																if(d.responsivePattern==="toggle")return u.addClass("fm-toggle");
																if(d.responsivePattern==="off-canvas") {u.addClass("fm-offcanvas");
																		return r.wrapInner('<div class="fm-inner" />').wrapInner('<div class="fm-outer" />')}
														}; l();
														a = e(".flexmenu .navicon"); s = e(".fm-inner");
														c = !1; i.on("click", function()

																{u = e(".flexmenu.fm-sm");

																		if(u.hasClass("fm-toggle"))return u.stop(!0, !0).slideToggle(0, "easeOutBounce");
																		if(u.hasClass("fm-offcanvas")) {if
																				(c)
																				{
																						//s.animate({right: 0, easing: "easeInOutQuint" }, { duration: 300, queue: false });


																						// u is side Menubar
																						//close mobile menu
																						u.animate({right: "-300px", easing: "easeOutExpo"}, {duration: 300, queue: false});
																						$(".overlay").fadeOut(600, "easeOutQuint");
																						return c = !1}

																				$(".overlay").click(function()
																						{
																								u.animate({right: "-300px", easing: "easeOutExpo"}, {duration: 300, queue: false});
																								$(".overlay").fadeOut(600, "easeOutQuint");
																								return c = !1
																						}
																				);

																				//s.animate({ right: "300px", easing: "easeInOutQuint" }, { duration: 300, queue: false });
																				//Open mobile menu
																				u.animate({right: 0, easing: "easeOutExpo"}, {duration: 300, queue: false});
																				$(".overlay").fadeIn(600, "easeOutQuint");
																				return c = !0;}
																}
														);


														h = function() {u.find("li ul").slideUp(0, "easeInOutQuint");
																if(d.responsivePattern==="off-canvas"&&e(".flexmenu.fm-sm").length)return function() {u = e(".flexmenu.fm-sm");
																				s.animate({right: 0});
																				u.animate({right: "-300px"});
																				$(".overlay").hide();
																				return c = !1}()

														};



														p = function(
														) {var t; t = f.width();
																if(t<=d.breakpoint) {

																		if
																		(e(".fm-lg").length)
																		{h();
																				u.hasClass("fm-toggle")&&u.hide()}u.removeClass("fm-lg").addClass("fm-sm"); i.show();

																		o.off("mouseenter mouseleave");
																		a.off("click"); return a.on("click", function(t)
																				{var n, r; t.stopPropagation();
																						r = e(this); n = r.parent(".with-ul").children("ul");
																						//Mobile Sub Open
																						return n.stop(!0, !0).slideToggle(300, "easeInOutQuint")}
																		)
																}h();
																u.removeClass("fm-sm").addClass("fm-lg");
																i.hide();
																u.hasClass("fm-toggle")&&u.slideDown(0, "easeInOutQuint");
																o.off("mouseenter mouseleave");
																a.off("click");
																return o.on("mouseenter", function() {return e(this).children("ul").stop(!0, !0).fadeIn(100, "easeOutQuint")}).on("mouseleave", function() {return e(this).children("ul").stop(!0, !0).fadeOut(300, "easeInOutQuint")})};
														p(); return f.resize(function() {clearTimeout(v); return v = setTimeout(p, 100)})}
										)
								}
								$('.flexmenu.fm-lg>ul>li').each(function()
										{
												var $href = "/" + $(this).find('a').attr('href');

												if ($href===window.location.pathname) {
														$(this).addClass("active");
												}
										}
								);
								$('.flexmenu.fm-sm>ul>li').each(function()
										{
												var $href = "/" + $(this).find('a').attr('href');

												if ($href===window.location.pathname) {
														$(this).addClass("active");
												}
										}
								);
						}
						
				)(jQuery, window)
		}
).call(this);


