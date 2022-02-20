import { StatusBar } from 'expo-status-bar';
import { StyleSheet, Text, View } from 'react-native';
import PirateContainer from './containers/PirateContainer';


export default function App() {
  return (
    <View style={styles.container}>
      <Text style={{fontWeight: "bold"}}>
        Welcome to Pirate Service App!
        {'\n'}
      </Text>
      <Text>
        Pirates:
        {'\n'}
      </Text>
      <PirateContainer/>
      <StatusBar style="auto" />
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
    alignItems: 'center',
    justifyContent: 'center',
  },
});
