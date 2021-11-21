function init() {
    var url = location.href;

    // 승인키
    var confmKey = '${POPUP_KEY}';

    // 도로명주소 검색결과 화면 출력유형, 4 : 도로명+지번+상세보기(관련지번, 관할주민센터, 상세건물명)
    var resultType = "4";

    // var useDetailAddr = "Y";
    var inputYn = "${JUSO.inputYn}";
    if (inputYn != "Y") {
        document.form.confmKey.value = confmKey;
        document.form.returnUrl.value = url;
        document.form.resultType.value = resultType;
        // document.form.useDetailAddr = useDetailAddr;
        document.form.action = "https://www.juso.go.kr/addrlink/addrLinkUrl.do";
        document.form.submit();
    } else {
        opener.jusoCallBack("${JUSO.roadFullAddr}", "${JUSO.roadAddrPart1}", "${JUSO.addrDetail}", "${JUSO.roadAddrPart2}", "${JUSO.jibunAddr}", "${JUSO.zipNo}");
        window.close();
    }
}