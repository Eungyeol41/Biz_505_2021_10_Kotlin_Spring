
function goPopup() {
    var pop = window.open(
        "${rootPath}/api/popup",
        "pop",
        "width=600, height=450, scrollbars=yes, resizable=yes"
    )
}

function jusoCallBack(
    roadFullAddr, roadAddrPart1, roadAddrPart2, addrDetail, jibunAddr, zipNo
) {
    roadAddrPart1 = input[name="roadAddrPart1"].val()
    addrDetail = input[name="addrDetail"].val()
}
