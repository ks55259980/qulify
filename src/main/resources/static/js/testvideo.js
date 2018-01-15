// //访问用户媒体设备的兼容方法
// function getUserMedia(constrains,success,error){
//     if(navigator.mediaDevices.getUserMedia){
//         //最新标准API
//         alert("use navigator.mediaDevices.getUserMedia");
//         navigator.mediaDevices.getUserMedia(constrains).then(success).catch(error);
//     } else if (navigator.webkitGetUserMedia){
//         //webkit内核浏览器
//         alert("use navigator.webkitGetUserMedia");
//         navigator.webkitGetUserMedia(constrains).then(success).catch(error);
//     } else if (navigator.mozGetUserMedia){
//         //Firefox浏览器
//         alert("use navigator.mozGetUserMedia");
//         navagator.mozGetUserMedia(constrains).then(success).catch(error);
//     } else if (navigator.getUserMedia){
//         //旧版API
//         alert("use navigator.getUserMedia");
//         navigator.getUserMedia(constrains).then(success).catch(error);
//     }
// }

// var video = document.getElementById("video");
// var canvas = document.getElementById("canvas");
// var context = canvas.getContext("2d");

// //成功的回调函数
// function success(stream){
//     //兼容webkit内核浏览器
//     var CompatibleURL = window.URL || window.webkitURL;
//     //将视频流设置为video元素的源
//     video.src = CompatibleURL.createObjectURL(stream);
//     alert(CompatibleURL + ", video.src: " + video.src);
//     //播放视频
//     video.play();
// }

// //异常的回调函数
// function error(error){
//     alert("访问用户媒体设备失败：",error.name, error.message);
// }

// if (navigator.mediaDevices.getUserMedia || navigator.getUserMedia || navigator.webkitGetUserMedia || navigator.mozGetUserMedia) {
//     //调用用户媒体设备，访问摄像头
//     getUserMedia({
//         video: { width:480, height:320 }
//     }, success, error);
// } else {
//     alert("你的浏览器不支持访问用户媒体设备");
// }

// //注册拍照按钮的单击事件
// document.getElementById("capture").addEventListener("click",function(){
//     //绘制画面
//     context.drawImage(video,0,0,480,320);
// });

ScanditSDK.configure("", {
    engineLocation: "/build",
    preloadEngineLibrary: true,
    preloadCameras: true,
});

ScanditSDK.BarcodePicker.create(document.getElementById('scandit-barcode-picker'), {
    playSoundOnScan: true,
    vibrateOnScan: true,
}).then(function(barcodePicker) {
    var scanSettings = new ScanditSDK.ScanSettings({
        enabledSymbologies: ['ean8', 'ean13', 'upca', 'upce', 'code128', 'code39', 'code93', 'itf'],
        codeDuplicateFilter: 1000,
    });
    barcodePicker.applyScanSettings(scanSettings);
    barcodePicker.onScan(function(scanResult) {
        alert(
            scanResult.barcodes.reduce(function(string, barcode) {
                return (
                    string + ScanditSDK.Barcode.Symbology.toHumanizedName(barcode.symbology) + ': ' + barcode.data + '\n'
                );
            }, '')
        );
    });
});
