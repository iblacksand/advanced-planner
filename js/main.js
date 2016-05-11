var file = [];
var errors = [];
function start(fileArray) {
	file = fileArray;
	compiles();
	showErrors();
}

function addError(line, message){
	errors.push("Error on line: " + line + " Error Message:" + message);
}

function compiles(){
	for (var i = 0; i < file.length; i++) {
		var line = file[i];
		if(isCommand(line)){
			switch(command(line).toLowerCase()){
				case "run":
				checkRun(i);
				break;
				case "loop":
				checkLoop();
				break;
				case "display":
				break;
				case "{":
				checkOpenBrackets(i);
				break;
				case "}":
				checkCloseBrackets(i);
				break;
			}
		}
	};
}

function showErrors(){
	for (var index = 0; index < errors.length; index++) {
		var element = errors[index];
		console.log("Error: " + element);
	}
}

function checkLoop(lineNum){

}

function isCommand(line){
	var command = command(line);
	var res = true;
	switch(command.toLowerCase()){
		case "loop":
		break;
		case "run":
		break;
		case "{":
		break;
		case "}":
		break;
		case "alias":
		break;
		default:
		addError("Not a command" , "Test");
		result = false;
		break;
	}
	return res;
}

function command(line){
	var command = "";
	for (var i = 0; i < line.length; i ++) {
		var str = line.substring(i, i + 1);
		if(!(str === " " || str === ".")){
			command += str;
		}
		else{
			break;
		}
	};
	return command;
}
