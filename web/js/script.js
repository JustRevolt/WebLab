function drawCanwas(id, r){

    var canvas = document.getElementById(id),
        context = canvas.getContext("2d");

    //var Ox = canvas.width / 2;
   // var Oy = canvas.height / 2;

    //очистка
    context.clearRect(0, 0, canvas.width, canvas.height);

    //прямоугольник
    context.beginPath();
    context.rect(150, 150, 130, 130);
    context.closePath();
    context.strokeStyle = "blue";
    context.fillStyle = "blue";
    context.fill();
    context.stroke();

    // сектор
    context.beginPath();
    context.moveTo(150, 150);
    context.arc(150, 150, 65, Math.PI, Math.PI/2, true);
    context.closePath();
    context.strokeStyle = "blue";
    context.fillStyle = "blue";
    context.fill();
    context.stroke();

    //треугольник
    context.beginPath();
    context.moveTo(150, 150);
    context.lineTo(150, 85);
    context.lineTo(215, 150);
    context.lineTo(150, 150);
    context.closePath();
    context.strokeStyle = "blue";
    context.fillStyle = "blue";
    context.fill();
    context.stroke();

    //отрисовка осей
    context.beginPath();
    context.strokeStyle = "black";
    context.fillStyle = "black";
    context.font = "10px Verdana";
    context.moveTo(150, 0); context.lineTo(150, 300);
    context.moveTo(150, 0); context.lineTo(145, 15);
    context.moveTo(150, 0); context.lineTo(155, 15);
    context.fillText("Y", 160, 10);
    context.moveTo(0, 150); context.lineTo(300, 150);
    context.moveTo(300, 150); context.lineTo(285, 145);
    context.moveTo(300, 150); context.lineTo(285, 155);
    context.fillText("X", 290, 135);

    // деления X
    context.moveTo(145, 20); context.lineTo(155, 20); context.fillText(r, 160, 20);
    context.moveTo(145, 85); context.lineTo(155, 85); context.fillText((r / 2), 160, 78);
    context.moveTo(145, 215); context.lineTo(155, 215); context.fillText(-(r / 2), 160, 215);
    context.moveTo(145, 280); context.lineTo(155, 280); context.fillText(-r, 160, 280);
    // деления Y
    context.moveTo(20, 145); context.lineTo(20, 155); context.fillText(-r, 20, 170);
    context.moveTo(85, 145); context.lineTo(85, 155); context.fillText(-(r / 2), 70, 170);
    context.moveTo(215, 145); context.lineTo(215, 155); context.fillText((r / 2), 215, 170);
    context.moveTo(280, 145); context.lineTo(280, 155); context.fillText(r, 280, 170);

    context.closePath();
    context.strokeStyle = "black";
    context.fillStyle = "black";
    context.stroke();
}

function clicCanvas(canv_Id, R) {
    var elem = document.getElementById(canv_Id);
    var br = elem.getBoundingClientRect();
    var left = br.left;
    var top = br.top;
    var event = window.event;
    var x = event.clientX-left;
    var y = event.clientY-top;
    var boolArea = isArea(x, y, R);
    drawPoint(canv_Id, x, y, boolArea);
}

function isArea(x, y, R) {
    x = R * (x - 150) / 130;
    y = R * (150 - y) / 130;
    if(x<=0 && y<=0 && x*x+y*y<=(R/2)*(R/2)){
        return 'true';
    }
    if(x>=0 && y>=0 && y<=(-1*x+0.5*R)){
        return 'true';
    }
    if(x>=0 && y<=0 && x<=R && y>=-R){
        return 'true';
    }
    return 'false';
}

function drawPoint(id, x, y, idArea){
    var canvas = document.getElementById(id),
        context = canvas.getContext("2d");
    context.beginPath();
    context.arc(x, y, 2, 0, 2 * Math.PI, false);
    context.closePath();
    if(isArea === 'true'){
        context.strokeStyle = "green";
        context.fillStyle = "green";
    } else {
        context.strokeStyle = "red";
        context.fillStyle = "red";
    }
    context.fill();
    context.stroke();
}

function convertFromPointToCanvas(canvas, xPoint, yPoint, radius)
{
    let xCenter = canvas.width / 2;
    let yCenter = canvas.height / 2;

    let quadrantWidth = (canvas.width - 40) / 2;
    let quadrantHeight = (canvas.height - 40) / 2;

    let xCanvas = xCenter + xPoint / radius * quadrantWidth;
    let yCanvas = yCenter - yPoint / radius * quadrantHeight;

    return [xCanvas, yCanvas];
}



