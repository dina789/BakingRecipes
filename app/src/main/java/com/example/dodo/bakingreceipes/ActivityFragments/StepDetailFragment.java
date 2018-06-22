package com.example.dodo.bakingreceipes.ActivityFragments;

import android.annotation.SuppressLint;
import android.app.Fragment;

import com.google.android.exoplayer2.DefaultLoadControl;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.LoadControl;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.util.Util;


public class StepDetailFragment extends Fragment {
  @SuppressLint("ValidFragment")
  StepDetailFragment(){









      private void initializePlayer(Uri mediaUri) {
          if (player == null) {
              TrackSelection.Factory videoTrackSelectionFactory = new AdaptiveVideoTrackSelection.Factory(bandwidthMeter);
              DefaultTrackSelector trackSelector = new DefaultTrackSelector(mainHandler, videoTrackSelectionFactory);
              LoadControl loadControl = new DefaultLoadControl();

              player = ExoPlayerFactory.newSimpleInstance(getContext(), trackSelector, loadControl);
              simpleExoPlayerView.setPlayer(player);

              String userAgent = Util.getUserAgent(getContext(), "Baking App");
              MediaSource mediaSource = new ExtractorMediaSource(mediaUri, new DefaultDataSourceFactory(getContext(), userAgent), new DefaultExtractorsFactory(), null, null);
              player.prepare(mediaSource);
              player.setPlayWhenReady(true);
          }
      }
      private fun releasePlayer() {
          if (player != null) {
              playbackPosition = player.getCurrentPosition()
              currentWindow = player.getCurrentWindowIndex()
              playWhenReady = player.getPlayWhenReady()
              player.release()
              player = null
          }








  }












}
//Resources

/*
ExoPlayer
https://medium.com/fungjai/playing-video-by-exoplayer-b97903be0b33




 */