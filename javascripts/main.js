var file = [];
function  start(fileArray) {
	file = fileArray;
	compiles();
	showErrors();
}

function compiles(){
	for (var i = 0; i < file.length; i++) {
		var line = file[i];
		if(isCommand(line)){
			switch(command(line).toLowerCase()){
				case "run":
				checkRun(line);
				break;
				case "loop":
				checkLoop;
				break;
				case "display":
				check
			}
		}
	};
}

function isCommand(line){
	String command = command(line);
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
		result = false;
		break;
	}
	return res;
}

function command(line){
	var command = "";
	for (var i = 0; i < line.length; i +) {
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