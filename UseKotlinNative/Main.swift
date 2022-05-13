//
//  Main.swift
//  UseKotlinNative
//
//  Created by fadi on 13/05/2022.
//

import UIKit
import shared

@UIApplicationMain
class AppDelegate: NSObject, UIApplicationDelegate {
    var window: UIWindow?

    func application(_ application: UIApplication, didFinishLaunchingWithOptions launchOptions: [UIApplication.LaunchOptionsKey : Any]? = nil) -> Bool {
        let window = UIWindow(frame: UIScreen.main.bounds)
        window.rootViewController = MainObjectContainer().mainObject
        window.makeKeyAndVisible()
        self.window = window
        return true
    }
}
