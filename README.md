# SportsApp

Sportsapp is an application developed natively on the android OS. it's developed using java as a programming language.
The application follows a simple MVP pattern with two main views: 
The first view fetches a list of possible sports from which you can choose from.
The second view takes the sport that the user selected and fetches information about the upcoming events for that specific sport. This information is refreshed every 30 seconds to simulate real time refreshing.

## Installation

For physical devices:
1)grab the "app-debug.apk" file in the "outputs" folder
2)transfer the apk into the physical device
3)in the device configurations enable installing applications from external sources
4)navigate to the apk file in the device
5)click on the file and accept the prompt message to install the app

For Emulator:
1)Use the adb push command to transfer the apk into the emulator files 

```bash
adb push <file-source-local> <destination-path-remote>
```

2)<file-source-local> should be the folder path for the location of the apk
3)<destination-path-remote> should be the folder path where the apk will be stored in the emulator
4)follow steps 3-5 of the physical device installation process
