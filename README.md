# Latin to Russian name transcriptor
**L2R Name transcriptor** is a tool for proper name orthographic transcription from various Latin-script using languages into Russian. It turns proper name spelling from Latin script to Cyrillic script using standard spelling system of respective language. L2R also supports Latin to Russian transliteration for a few non-Roman alphabet based languages like Greek or Chinese.

**Name transcriptor** is a project in process. As for now it presents only the back-end logics for name transcription. Basic GUI support will be introduced at a later point. At this time app supports a dozen languages and new ones are added on a weekly basis.

## Features

Since service is primarily intended to transcribe proper names (like personal or geographical names) it implies words are provided in either of three conventional character cases: lower case, Title case and ALLCAPS. Words in MiXeD case are automatically cast to Title case. 

Automatic transcription by its very nature can not offer flawless result at all times but aims to be as close to it as possible.

List of currently supported languages:
* Russian (from Romanized form back to Cyrillic)
* Albanian
* Armenain (from Romanized form to Cyrillic)
* Bulgarian (from Romanized form back to Cyrillic)
* Chinese (from Romanized form to Cyrillic)
* Czech
* Georgian (from Romanized form to Cyrillic)
* Greek (from Romanized form to Cyrillic)
* Macedonian (from Romanized form back to Cyrillic)
* Romanian / Moldovan
* Serbocroatian
* Slovak
* Turkish
* Ukrainian (from Romanized form back to Cyrillic)

Any feedback is kindly welcome.

## Launch

App can be launched by building a project in Maven and running a .jar file.