var file = [];
var errors = [];

function start() {
    errors = [];
    file = document.getElementById("code").value.split('\n');
    document.getElementById("errors").value = "-------\n\nAdvanced-Planner Online Compiler\nBy John Elizarraras\n\n-------\n\nCompiling...Please Wait";
    compiles();
    setTimeout(showErrors, 500);
}

function addError(line, message) {
    errors.push("Error on line: " + line + " Error Message: " + message);
    errors.push("---")
}

/**
 * goes through the text field and checks each line
 */
function compiles() {
    for (var i = 0; i < file.length; i++) {
        var line = file[i];
        if (isCommand(i)) {
            switch (command(i).toLowerCase()) {
            case "run":
                break;
            case "loop":
                checkLoop(i);
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

function showErrors() {
    var set = "-------\n\nAdvanced-Planner Online Compiler\nBy John Elizarraras\n\n-------\n"
    for (var index = 0; index < errors.length; index++) {
        var element = errors[index];
        set += "\n" + element;
    }
    if(errors.length == 0) set += "\nNo Errors\n---";
    set += "\nCompiled at " + Date().substring(16,25);
    document.getElementById("errors").value = set;
}

function lineContains(want, toCheck, p, q) {
    try {
        return want == toCheck.substring(p, q);
    } catch (err) {}
    return false;
}

function checkOpenBrackets(k) {
    try {
        if (!lineContains("loop", file[k - 1], 0, 4)) addError(k + 1, "Opend bracket without loop before");
    } catch (err) {
        addError(k + 1, "Open bracket without loop before");
    }
}

function checkCloseBrackets(k) {
    try {
        var needError = true;
        for (var i = k - 1; i >= 0; i--) {
            if (lineContains("loop", file[i], 0, 4)) {
                needError = false;
                break;
            } else if (lineContains("}", file[i], 0, 4)) addError(i + 1, "'}' before '{'");
        }
        if (needError) addError(index, "'}' with no opening bracket");
    } catch (err) {
        addError(k + 1, "Closed bracket in illegal position");
    }
}

function checkLoop(lineNum) {
    var mods = this.object(lineNum);
    if (mods.length < 2) addError(lineNum + 1, "Not Enough Modifiers");
    else if (mods.length > 2) addError(lineNum + 1, "Too Many Modifiers");
    else {
        if (Number.isNaN(mods[0].substring(0, mods[0].length - 1))) addError(lineNum + 1, "Time is not a number");
        switch (mods[0].substring(mods[0].length - 1)) {
        case "s":
            break;
        case "m":
            break;
        case "h":
            break;
        case "d":
            break;
        default:
            addError(lineNum + 1, "Not an acceptable time format");
            break;
        }
        if (isNaN(mods[1])) addError(lineNum + 1, "Second modifier is not a number");
        else {
            if (mods[1] < 0) addError(lineNum + 1, "Second modifier is negative");
        }
        try {
            if (!(file[lineNum + 1] == "{")) addError(lineNum + 2, "Is not a '{'");
            var needsError = true;
            for (var i = lineNum + 2; i < file.length; i++) {
                if (file[i] == "{") addError(i + 1, "Another '{' before '}'");
                else if (file[i] == "}") {
                    needsError = false;
                    break;
                }
            }
            if (needsError) addError(file.length + 1, "No Closing '}'");
        } catch (err) {
            addError(file.length + 1, "Loop doesn't open/close");
        }
    }
}

function object(line) {
    if (line < file.length && line > -1) {
        var a = [];
        var curLine = file[line];
        var startFound = false;
        var start = 0;
        for (var i = 0; i < curLine.length; i++) {
            if (curLine.substring(i, i + 1) === " ") {
                start = i;
                startFound = true;
                break;
            }
        }
        if (!startFound) return [];
        var str = curLine.substring(start + 1);
        var build = "";
        var lastCut = 0;
        for (var i = 0; i < str.length; i++) {
            var c = str.substring(i, i + 1);
            if (c === " ") {
                a.push(build.trim());
                build = "";
                lastCut = i;
            } else build += c.trim();
        }
        a.push(str.substring(lastCut).trim());
        return a;

    } else return [];
}

function isCommand(line) {
    var command = this.command(line);
    var res = true;
    switch (command.toLowerCase()) {
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
    case "display":
        break;
    default:
        addError(line + 1, "This is not a command");
        result = false;
        break;
    }
    return res;
}

function command(line) {
    var command = "";
    for (var i = 0; i < file[line].length; i++) {
        var str = file[line].substring(i, i + 1);
        if (!(str === " " || str === ".")) {
            command += str;
        } else {
            break;
        }
    };
    return command;
}

function pause() {
    return "";
}
