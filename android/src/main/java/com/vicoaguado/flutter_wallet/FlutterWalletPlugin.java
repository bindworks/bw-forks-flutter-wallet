package com.vicoaguado.flutter_wallet;

import androidx.annotation.NonNull;

import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugin.common.PluginRegistry.Registrar;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.BinaryMessenger;

/** FlutterWalletPlugin */
public class FlutterWalletPlugin implements FlutterPlugin, MethodCallHandler {
  private MethodChannel channel;

  private static void setup(FlutterWalletPlugin plugin, BinaryMessenger binaryMessenger) {
    plugin.channel = new MethodChannel(binaryMessenger, "flutter_wallet");
    plugin.channel.setMethodCallHandler(new FlutterWalletPlugin());
  }
  
  /** Plugin registration. */
  public void registerWith(Registrar registrar) {
    setup(this, registrar.messenger());
  }

  @Override
  public void onAttachedToEngine(@NonNull FlutterPluginBinding flutterPluginBinding) {
    setup(this, flutterPluginBinding.getBinaryMessenger());
  }

  @Override
  public void onMethodCall(MethodCall call, Result result) {
    if (call.method.equals("getPlatformVersion")) {
      result.success("Android " + android.os.Build.VERSION.RELEASE);
    } else {
      result.notImplemented();
    }
  }

  @Override
  public void onDetachedFromEngine(@NonNull FlutterPluginBinding binding) {
    channel.setMethodCallHandler(null);
  }
}
