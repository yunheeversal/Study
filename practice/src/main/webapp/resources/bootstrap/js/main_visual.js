$(function(){

	var carouselWrap = $('#carousel-example-generic'),
		 typedTxtArr = [
			'새벽에 같이 별 보러 가실 분',
			'모여서 각자 코딩하실 분 #비대면',
			'식물 그만 죽이고 싶어요 #도와줘요',
			'같은 주제로 그림 그리실 분!'
		 ],
		 typed, typedObj;	

	var typedFunc = function( a, b ) {
		typed = new Typed(a[0], {
			strings: [
				typedTxtArr[ b ]
			],
			stringsElement: null,
			typeSpeed: 100,
			startDelay: 1000,
			smartBackspace: false,
			backSpeed: 60,
			backDelay: 5000,
			loop: true,
			loopCount: 5,
			showCursor: false,
			cursorChar: "|",
			attr: null,
			contentType: 'html',
			callback: function() {},
			preStringTyped: function() {},
			onStringTyped: function() {
				setTimeout(function(){
					carouselWrap.carousel('next');
				}, 2000);
			},
			resetCallback: function() {},
			onReset: function(self) { 
				
			}
		});
	}

	carouselWrap.on('slid.bs.carousel', function () {
		var idx =$(this).find('.active').index(),
			 typedObj = $('.typing').eq( idx );
			 typed.destroy();
			 typedFunc( typedObj, idx );
	});
	
	// init
	typedFunc( $('.typing').eq(0), 0); 

});