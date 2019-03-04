package com.example.mymusic;

public class AndroidBuildingMusicPlayerActivity extends Activity
        implements OnCompletionListener, SeekBar.OnSeekBarChangeListener {

    private ImageButton btnPlay;
    private ImageButton btnForward;
    private ImageButton btnBackward;
    private ImageButton btnNext;
    private ImageButton btnPrevious;
    private ImageButton btnPlaylist;
    private ImageButton btnRepeat;
    private ImageButton btnShuffle;
    private SeekBar songProgressBar;
    private TextView songTitleLabel;

    private TextView songCurrentDurationLabel;
    private TextView songTotalDurationLabel;
    // Media Player
    private MediaPlayer mp;
    // Handler to update UI timer, progress bar etc,.
    private Handler mHandler = new Handler();
    ;
    private SongsManager songManager;
    private Utilities utils;
    private int seekForwardTime = 5000; // 5000 milliseconds
    private int seekBackwardTime = 5000; // 5000 milliseconds
    private int currentSongIndex = 0;
    private boolean isShuffle = false;
    private boolean isRepeat = false;
    private ArrayList<HashMap<String, String>> songsList = new ArrayList<HashMap<String, String>>();

    // All player buttons
    btnPlay = (ImageButton) findViewById(R.id.btnPlay);
    btnForward = (ImageButton) findViewById(R.id.btnForward);
    btnBackward = (ImageButton) findViewById(R.id.btnBackward);
    btnNext = (ImageButton) findViewById(R.id.btnNext);
    btnPrevious = (ImageButton) findViewById(R.id.btnPrevious);
    btnPlaylist = (ImageButton) findViewById(R.id.btnPlaylist);
    btnRepeat = (ImageButton) findViewById(R.id.btnRepeat);
    btnShuffle = (ImageButton) findViewById(R.id.btnShuffle);
    songProgressBar = (SeekBar) findViewById(R.id.songProgressBar);
    songTitleLabel = (TextView) findViewById(R.id.songTitle);
    songCurrentDurationLabel = (TextView) findViewById(R.id.songCurrentDurationLabel);
    songTotalDurationLabel = (TextView) findViewById(R.id.songTotalDurationLabel);

    // Mediaplayer
    mp = new MediaPlayer();
    songManager = new SongsManager();
    utils = new Utilities();

    // Listeners
        songProgressBar.setOnSeekBarChangeListener(this); // Important
        mp.setOnCompletionListener(this); // Important

    // Getting all songs list
    songsList = songManager.getPlayList();

    /**
     * Button Click event for Play list click event
     * Launches list activity which displays list of songs
     * */
        btnPlaylist.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View arg0) {
            Intent i = new Intent(getApplicationContext(), PlayListActivity.class);
            startActivityForResult(i, 100);
        }
    });

    /**
     * Receiving song index from playlist view
     * and play the song
     * */
    @Override
    protected void onActivityResult(int requestCode,
                                    int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == 100){
            currentSongIndex = data.getExtras().getInt("songIndex");
            // play selected song
            playSong(currentSongIndex);
        }

    }
}
    /**
     * Function to play a song
     * @param songIndex - index of song
     * */
    public void  playSong(int songIndex){
        // Play song
        try {
            mp.reset();
            mp.setDataSource(songsList.get(songIndex).get("songPath"));
            mp.prepare();
            mp.start();
            // Displaying Song title
            String songTitle = songsList.get(songIndex).get("songTitle");
            songTitleLabel.setText(songTitle);

            // Changing Button Image to pause image
            btnPlay.setImageResource(R.drawable.btn_pause);

            // set Progress bar values
            songProgressBar.setProgress(0);
            songProgressBar.setMax(100);

            // Updating progress bar
            updateProgressBar();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }