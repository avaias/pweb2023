import { View, Text, StyleSheet } from "react-native";


const ExercicioUmScreen = (props) =>{
    return (
        <View style = {styles.container}>
            <Text style = {styles.textBox}>App</Text>
            <View style = {styles.alignBox}>
                <View style = {styles.redBox}></View>
                <View style = {styles.purpleBox}></View>
            </View>
            <View style = {styles.greenBox}></View>
        </View>
      );
}
    
    const styles = StyleSheet.create({
      container: {
        flex: 1,
        backgroundColor: '#fff'
      },
      textBox:{
        borderWidth: 2,
        width: "100%",
        paddingVertical: 15,
        textAlign: 'center',
        fontSize: 18,
        fontWeight: 700
      },
      alignBox:{
        flex: 1,
        flexDirection: "row",
        justifyContent: "space-between"
      },
      redBox:{
        backgroundColor: '#FF0000',
        width: 55,
        height: 55
      },
      purpleBox:{
        backgroundColor: '#5542ff',
        width: 55,
        height: 55
      },
      greenBox:{
        backgroundColor: '#00ff04', 
        width: 55,
        height: 55
      }
    });
    
export default ExercicioUmScreen;
