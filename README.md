# RotateProgressLibrary
[![Download](https://api.bintray.com/packages/nakkar1218/maven/rotateprogress/images/download.svg)](https:bintray.com/nakkar1218/maven/rotateprogress/_latestVersion)

An Android Animation library which easily add rotate progress bar.

## How to use
### Integration
```build.gradle
dependencies {
    compile 'com.shohei.rotateprogress:rotateprogress:0.1.1'
}
```
### Usage
```.java
RotateProgressBar rotateProgressBar = (RotateProgressBar) findViewById(R.id.rotate_progress_bar);

rotateProgressBar.start();
```
#### Advanced 1
You can change the rotate duration.
```.java
rotateProgressBar.setDuration(2000);
```
#### Advanced 2
You can change the progress bar Color.
```.java
rotateProgressBuilder.setColors(Color.RED, Color.BLUE, Color.GREEN, Color.CYAN);
rotateProgressBuilder.setColors("#F44336", "#E91E63", "#9C27B0", "#673AB7");

// for color.xml
rotateProgressBuilder.setColorsResource(R.color.colorPrimary, R.color.colorAccent, R.color.colorPrimaryDark);
```

## License
```
Copyright 2016 nakkar1218

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
