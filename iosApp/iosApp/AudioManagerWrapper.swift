import AVFoundation

@objc class AudioPlayerWrapper: NSObject {
    var musicPlayer: AVAudioPlayer?
    var soundPlayers: [String: AVAudioPlayer] = [:]

    @objc func playBackgroundMusic(loop: Bool) {
        if let url = Bundle.main.url(forResource: "background_music", withExtension: "mp3") {
            musicPlayer = try? AVAudioPlayer(contentsOf: url)
            musicPlayer?.numberOfLoops = loop ? -1 : 0
            musicPlayer?.play()
        }
    }

    @objc func playSoundEffect(_ name: String) {
        if let url = Bundle.main.url(forResource: name, withExtension: "mp3") {
            let player = try? AVAudioPlayer(contentsOf: url)
            player?.play()
            soundPlayers[name] = player
        }
    }

    @objc func pause() {
        musicPlayer?.pause()
    }

    @objc func stop() {
        musicPlayer?.stop()
    }

    @objc func setVolume(_ volume: Float) {
        musicPlayer?.volume = volume
    }
}