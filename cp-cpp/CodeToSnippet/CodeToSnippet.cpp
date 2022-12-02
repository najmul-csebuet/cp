#include <bits/stdc++.h>

#include <filesystem>
#include <fstream>
#include <iostream>

using namespace std;
namespace fs = std::filesystem;

string cppJson = "~/.config/Code/User/snippets/cpp.json";

ifstream fin;
ofstream fout("snippets.txt");

vector<string> split(string s, string del = " ") {
  vector<string> parts;
  int start, end = -1 * del.size();
  do {
    start = end + del.size();
    end = s.find(del, start);
    parts.push_back(s.substr(start, end - start));
  } while (end != -1);
  return parts;
}

void writeHeader() {
  string header = R"({
	// Place your snippets for cpp here.

    // Each snippet is defined under a snippet name and has a prefix, body and description.
    // The prefix is what is used to trigger the snippet and the body will be expanded and inserted.

    // Possible variables are:
	// $1, $2 for tab stops, $0 for the final cursor position, and ${1:label}, ${2:another} for placeholders.

    // Placeholders with the same ids are connected.

	// Example:

	// "Print to console": {
	// 	"prefix": "log",
	// 	"body": [
	// 		"console.log('$1');",
	// 		"$2"
	// 	],
	// 	"description": "Log output to console"
	// }
  )";

  fout << header;
}

void handleSingleLine(string prefixAndBody) {
  vector<string> parts = split(prefixAndBody, ": ");
  string prefix = parts[0];
  string snippetName = parts[1];
  string body = snippetName;

  fout << "\t\"" << snippetName << "\": {\n";
  fout << "\t\t\"prefix\": "
       << "\"" << prefix << "\",\n";
  fout << "\t\t\"body\": [\n";

  fout << "\t\t\t\"" << body << "\",\n";

  if (body.find("$0") == string::npos) {
    fout << "\t\t\t\""
         << "$0"
         << "\",\n";
  }

  fout << "\t\t],\n\t},\n\n";
}

void handleMultiLine(string prefixAndBody) {
  vector<string> parts = split(prefixAndBody, ": ");
  string prefix = parts[0];
  string snippetName = parts[1];
  string body;

  fout << "\t\"" << snippetName << "\": {\n";
  fout << "\t\t\"prefix\": "
       << "\"" << prefix << "\",\n";
  fout << "\t\t\"body\": [\n";

  string separator;
  getline(fin, separator);

  while (true) {
    getline(fin, body);
    if (body == ".") {
      fout << "\t\t],\n\t},\n\n";
      break;
    }
    fout << "\t\t\t\"" << body << "\",\n";
  }
}

void printComment() {
  string comment1, comment2, comment3;
  getline(fin, comment1);
  getline(fin, comment2);
  getline(fin, comment3);
  // fin.ignore();

  fout << "\n\t" << comment1 << endl;
  fout << "\t" << comment2 << endl;
  fout << "\t" << comment3 << endl << endl;
}

string getFirstNonEmptyLine() {
  // iterate until we get a : line
  string line;
  while (true) {
    getline(fin, line);
    if (!line.empty()) {
      break;
    }
  }
  return line;
}

void generate(string inputFileName) {
  fin.open(inputFileName);

  printComment();

  string firstLine;

  while (fin.good()) {
    // iterate until we get a : line
    firstLine = getFirstNonEmptyLine();
    if (firstLine.find("$0") != string::npos) {
      // this is 1 line snippet
      handleSingleLine(firstLine);
    } else if (firstLine.find(";") != string::npos) {
      // this is 1 line snippet
      handleSingleLine(firstLine);
    } else {
      handleMultiLine(firstLine);
    }
  }

  fin.close();
}

vector<string> files() {
  string path(".");
  string ext(".txt");
  vector<string> files;

  for (auto& p : fs::recursive_directory_iterator(path)) {
    if (p.path().extension() != ext) continue;

    auto fileName = p.path().stem().string() + ".txt";
    if (fileName != "snippets.txt") {
      files.push_back(fileName);
    }
  }
  return files;
}

int main(int argc, char const* argv[]) {
  writeHeader();

  vector<string> allTextFiles = files();
  sort(allTextFiles.begin(), allTextFiles.end());

  for (auto fileName : allTextFiles) {
    generate(fileName);
  }

  fout << "}" << endl;
  fout.close();

  return 0;
}
