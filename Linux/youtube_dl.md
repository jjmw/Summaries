# youtube_dl

### Get all possible available formats

```bash
youtube-dl -F  'https:// .....'
```

### Download movie in specified quality

```bash
youtube-dl -f <int> 'https://......'
```

### If problems with audio and video

```bash
youtube-dl -f 'bestvideo[ext=mp4]+bestaudio[ext=m4a]/bestvideo+bestaudio' --merge-output-format mp4 'http://....'
```

[More info](https://askubuntu.com/questions/486297/how-to-select-video-quality-from-youtube-dl)


ffmpeg -v 5 -y -i input.m4a -acodec libmp3lame -ac 2 -ab 192k output.mp3