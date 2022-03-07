import 'dart:async';
import 'package:flutter/services.dart';

class FlutterWallet {
  static const MethodChannel _channel =
      const MethodChannel('com.vico-aguado.flutter/wallet');

  /// Returns bool value if iOS can covert one pkpass file
  ///
  /// - parameters:
  ///    - pkpass: List with <int> values from pkpass file
  static Future<bool?> addPass({required List<int> pkpass}) async {
    final bool? result = await _channel
        .invokeMethod('addWalletPass', <String, dynamic>{'pkpass': pkpass});
    return result;
  }
}
